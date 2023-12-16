CREATE TABLE IF NOT EXISTS stanowisko (
                                          "id"	INTEGER,
                                          "nazwa"	TEXT,
                                          PRIMARY KEY("id")
    );
CREATE TABLE IF NOT EXISTS pracownik (
                                         "id"	INTEGER,
                                         "imie"	TEXT,
                                         "nazwisko"	TEXT,
                                         "stanowisko"	INTEGER,
                                         PRIMARY KEY("id"),
    FOREIGN KEY("stanowisko") REFERENCES stanowisko("id")
    );
CREATE TABLE IF NOT EXISTS jednostka (
                                         "id"	INTEGER,
                                         "nazwa"	TEXT,
                                         PRIMARY KEY("id")
    );
CREATE TABLE IF NOT EXISTS pracjednlnk (
                                           "id_prac"	INTEGER,
                                           "id_jedn"	INTEGER,
                                           FOREIGN KEY("id_prac") REFERENCES pracownik("id"),
    FOREIGN KEY("id_jedn") REFERENCES jednostka("id")
    );