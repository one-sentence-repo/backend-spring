create
    or replace function update_updated_at()
    returns trigger as
$$
begin
    new.updated_at = now();
    return new;
end;
$$
    language plpgsql;

do
$$
    declare
        tbl record;
    begin
        -- public 스키마 내 모든 테이블 조회
        for tbl in
            select table_name
            from information_schema.tables
            where table_schema = 'public'
              and table_type = 'BASE TABLE'
            loop
                -- 1. updated_at 컬럼 추가 (존재하지 않는 경우에만)
                execute format(
                        'alter table %I add column if not exists updated_at timestamp default now()',
                        tbl.table_name
                        );

                -- 2. 트리거 추가
                execute format(
                        'create trigger set_updated_at
                         before update on %I
                         for each row
                         execute function update_updated_at()',
                        tbl.table_name
                        );
            end loop;
    end;
$$;
