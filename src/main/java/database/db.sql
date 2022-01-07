create table lotto_statistic(
    lotto_statistic_id bigint not null AUTO_INCREMENT,
    tree_match int DEFAULT 0 not null,
    four_match int DEFAULT 0 not null,
    five_match int DEFAULT 0 not null,
    six_match int DEFAULT 0 not null,
    profit_rate int DEFAULT 0 not null,
    winning_number_1 char(2),
    winning_number_2 char(2),
    winning_number_3 char(2),
    winning_number_4 char(2),
    winning_number_5 char(2),
    winning_number_6 char(2),
    winning_number_bonus char(2),
    purchase_count int DEFAULT 0 not null,
    normal_lotto_count int DEFAULT 0 not null,
    auto_lotto_count int DEFAULT 0 not null,
    PRIMARY KEY (lotto_statistic_id)
);

create table lotto(
    lotto_id bigint not null AUTO_INCREMENT,
    lotto_statistic_id bigint,
    number_1 char(2),
    number_2 char(2),
    number_3 char(2),
    number_4 char(2),
    number_5 char(2),
    number_6 char(2),
    status char(10),
    PRIMARY KEY (lotto_id),
    FOREIGN KEY (lotto_statistic_id) REFERENCES lotto_statistic(lotto_statistic_id)
);
