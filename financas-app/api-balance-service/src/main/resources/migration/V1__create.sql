CREATE TABLE balances (
    id varchar not null primary key,
    transacao_id varchar not null,
    conta_id varchar not null unique,
    valor float8 not null
);

create index balances_account_id_index on balances (conta_id);