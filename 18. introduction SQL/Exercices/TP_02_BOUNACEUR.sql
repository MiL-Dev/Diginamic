CREATE TABLE ARCTICLE (
    id int NOT NULL PRIMARY KEY,
    REF varchar(255) NOT NULL,
    DESIGNATION varchar(255) NOT NULL,
    PRIX decimal(7,2) NOT NULL,
    ID_FOU int NOT NULL
);
CREATE TABLE FOURNISSEUR (
   ID int NOT NULL PRIMARY KEY,
   NOM varchar(255) NOT NULL
);

CREATE TABLE BON (
    ID int NOT NULL PRIMARY KEY,
    NUMERO int,
    DATE_CMDE TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    DELAI int,
    ID_FOU int NOT NULL
);
CREATE TABLE COMPO (
    ID int NOT NULL AUTO_INCREMENT PRIMARY KEY , 
    QTE int,
    ID_ART int,
    ID_BON int NOT NULL
);

ALTER TABLE ARCTICLE ADD CONSTRAINT FOREIGN KEY (ID_FOU) REFERENCES FOURNISSEUR(ID);
ALTER TABLE BON ADD CONSTRAINT FOREIGN KEY (ID_FOU) REFERENCES FOURNISSEUR(ID);
ALTER TABLE COMPO ADD CONSTRAINT FOREIGN KEY (ID_ART) REFERENCES ARCTICLE(ID);
ALTER TABLE COMPO ADD CONSTRAINT FOREIGN KEY (ID_BON) REFERENCES BON(ID);