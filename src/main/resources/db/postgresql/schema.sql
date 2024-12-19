create table if not exists user_info
(
    id         bigserial primary key,
    email      varchar(30) unique,
    password   varchar(255) not null,
    user_name  varchar(15),
    avatar_url varchar(255),
    about_me   varchar(250),
    mbti       varchar(4),
    updated_at timestamp default current_timestamp,
    created_at timestamp default current_timestamp
);

create table if not exists post
(
    id            bigserial primary key,
    user_id       bigint                             not null,
    emotion_level varchar(10),
    content       text                               not null,
    title         varchar(30),
    like_count    int              default 0,
    comment_count int              default 0,
    tags          text[],
    access_type   access_type_enum default 'public'  not null,
    post_type     post_type_enum   default 'journal' not null,
    created_at    timestamp        default current_timestamp,
    updated_at    timestamp        default current_timestamp,
    foreign key (user_id) references user_info (id)
);

create table if not exists comment
(
    id         bigserial primary key,
    content    text not null,
    post_id    int,
    comment_id int,
    user_id    int  not null,
    comment    int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (post_id) references post (id) on delete cascade,
    foreign key (comment_id) references comment (id) on delete cascade,
    foreign key (user_id) references user_info (id)
);

create table if not exists report
(
    id             bigserial primary key,
    reporter_id    bigint not null,
    reason         text   not null,
    target_post_id bigint,
    target_comment bigint,
    created_at     timestamp default current_timestamp,
    updated_at     timestamp default current_timestamp,
    foreign key (target_post_id) references user_info (id),
    foreign key (target_comment) references comment (id)
);

create table if not exists todo_folder
(
    id         bigserial primary key,
    color      varchar(25),
    index      int         not null,
    name       varchar(25) not null,
    user_id    bigint      not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (user_id) references user_info (id) on delete cascade
);

create table if not exists todo
(
    id          bigserial primary key,
    folder_id   bigint not null,
    index       int    not null,
    is_complete boolean   default false,
    memo        text,
    content     text   not null,
    user_id     bigint not null,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp,
    foreign key (folder_id) references todo_folder (id) on delete cascade,
    foreign key (user_id) references user_info (id) on delete cascade
);

create table if not exists follow
(
    id                bigserial primary key,
    follower_user_id  bigint not null,
    following_user_id bigint not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp,
    foreign key (follower_user_id) references user_info (id) on delete cascade,
    foreign key (following_user_id) references user_info (id) on delete cascade
);

create table if not exists "like"
(
    id         bigserial primary key,
    user_id    bigint not null,
    post_id    bigint not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (user_id) references user_info (id),
    foreign key (post_id) references post (id) on delete cascade
);

create table if not exists garden
(
    id         bigserial primary key,
    posts      jsonb[] not null,
    user_id    bigint  not null,
    year_month text    not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (user_id) references user_info (id)
)