create table if not exists user_info
(
    id         serial primary key,
    created_at timestamp default current_timestamp,
    user_name  varchar(15) not null,
    email      varchar(30) not null,
    avatar_url varchar(255),
    about_me   varchar(250),
    mbti       varchar(4)
);

create type post_type_enum as enum ('article', 'journal');
create type access_type_enum as enum ('public', 'private');

create table if not exists post
(
    id            serial primary key,
    created_at    timestamp        default current_timestamp,
    user_id       int                                not null,
    emotion_level varchar(10),
    content       text                               not null,
    title         varchar(30),
    comment       int              default 0,
    tags          text[],
    access_type   access_type_enum default 'public'  not null,
    post_type     post_type_enum   default 'journal' not null,
    foreign key (user_id) references user_info (id)
);

create table if not exists comment
(
    id         serial primary key,
    created_at timestamp default current_timestamp,
    content    text not null,
    post_id    int,
    comment_id int,
    user_id    int  not null,
    comment    int,
    foreign key (post_id) references post (id) on delete cascade,
    foreign key (comment_id) references comment (id) on delete cascade,
    foreign key (user_id) references user_info (id)
);

create table if not exists report
(
    id             serial primary key,
    created_at     timestamp default current_timestamp,
    reporter_id    int  not null,
    reason         text not null,
    target_post_id int,
    target_comment int,
    foreign key (target_post_id) references user_info (id),
    foreign key (target_comment) references comment (id)
);

create table if not exists todo_folder
(
    id         serial primary key,
    created_at timestamp default current_timestamp,
    color      varchar(25),
    index      int         not null,
    name       varchar(25) not null,
    user_id    int         not null,
    foreign key (user_id) references user_info (id) on delete cascade
);

create table if not exists todo
(
    id          serial primary key,
    created_at  timestamp default current_timestamp,
    folder_id   int  not null,
    index       int  not null,
    is_complete boolean   default false,
    memo        text,
    content     text not null,
    user_id     int  not null,
    foreign key (folder_id) references todo_folder (id) on delete cascade,
    foreign key (user_id) references user_info (id) on delete cascade
);

create table if not exists follow
(
    id                serial primary key,
    created_at        timestamp default current_timestamp,
    follower_user_id  int not null,
    following_user_id int not null,
    foreign key (follower_user_id) references user_info (id) on delete cascade,
    foreign key (following_user_id) references user_info (id) on delete cascade
);

create table if not exists "like"
(
    id         serial primary key,
    created_at timestamp default current_timestamp,
    user_id    int not null,
    post_id    int not null,
    foreign key (user_id) references user_info (id),
    foreign key (post_id) references post (id) on delete cascade
);

create table if not exists garden
(
    id         serial primary key,
    created_at timestamp default current_timestamp,
    posts      jsonb[] not null,
    user_id    int     not null,
    year_month text    not null,
    foreign key (user_id) references user_info (id)
)