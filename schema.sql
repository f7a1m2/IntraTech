CREATE TABLE categorie_postes
(
    id  serial PRIMARY KEY,
    nom varchar(100) NOT NULL
);

-- Table postes
CREATE TABLE postes
(
    id           SERIAL PRIMARY KEY,
    intitule     VARCHAR(100) NOT NULL,
    id_categorie VARCHAR(100),
    description  TEXT
);

-- Tables de base pour la gestion des utilisateurs et des rôles
CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    user_name VARCHAR(255),
    email     VARCHAR(255) UNIQUE,
    pass      VARCHAR(255),
    user_role VARCHAR(50)
);

/*competences_requises JSON,
experience_requise JSON,
education_requise JSON,
importance_criteres JSON*/

create table competences
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL unique
);

create table experiences
(
    id               SERIAL PRIMARY KEY,
    nom              VARCHAR(100) NOT NULL,
    debut_intervalle int          not null check ( debut_intervalle >= 0 ),
    fin_intervalle   int          not null check ( debut_intervalle < fin_intervalle)
);

create table education
(
    id               SERIAL PRIMARY KEY,
    nom              VARCHAR(100) NOT NULL,
    score_importance int check ( score_importance >= 0 )
);

-- Table pour les compétences liées aux postes
CREATE TABLE importance_competence
(
    id            SERIAL PRIMARY KEY,
    id_poste      INT REFERENCES postes (id),
    id_competence INT REFERENCES competences (id),
    coefficient   decimal NOT NULL
);

-- Table pour les expériences liées aux postes
CREATE TABLE importance_experience
(
    id            SERIAL PRIMARY KEY,
    id_poste      INT REFERENCES postes (id),
    id_experience INT REFERENCES experiences (id),
    coefficient  DECIMAL NOT NULL
);

-- Table pour les éducations liées aux postes
CREATE TABLE importance_education
(
    id           SERIAL PRIMARY KEY,
    id_poste     INT REFERENCES postes (id),
    id_education INT REFERENCES education (id),
    coefficient  DECIMAL NOT NULL
);
-- Table offres
CREATE TABLE offres
(
    id               SERIAL PRIMARY KEY,
    id_poste         INT REFERENCES postes (id) ON DELETE CASCADE,
    titre            VARCHAR(100) NOT NULL,
    description      TEXT,
    date_publication DATE         NOT NULL,
    date_expiration  DATE,
    nombre_positions INT          NOT NULL
);

CREATE TABLE candidats (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES Users(id), -- Liaison avec la table Users existante
    cv_data TEXT,
    status VARCHAR(50)
);

-- Table cv
CREATE TABLE cv
(
    id             SERIAL PRIMARY KEY,
    id_candidat    INT REFERENCES candidats (id) ON DELETE CASCADE,
    contenu        TEXT,
    experience     DECIMAL,
    education TEXT,
    coeff_filtrage DECIMAL
);

ALTER TABLE cv 
    DROP COLUMN coeff_filtrage;
ALTER TABLE cv
    ADD COLUMN coeff_filtrage DECIMAL;

create table cv_competences
(
    id            SERIAL PRIMARY KEY,
    id_cv         int references cv (id)          not null,
    id_competence int references competences (id) not null
);

CREATE TABLE candidatures (
    id SERIAL PRIMARY KEY,
    id_candidat INT REFERENCES candidats(id),
    id_offre INT REFERENCES offres(id),
    date_candidature DATE NOT NULL,
    statut VARCHAR(50)
);

-- Modification de la table evaluations
CREATE TABLE evaluations
(
    id                  SERIAL PRIMARY KEY,
    id_candidature      INT REFERENCES candidatures (id) ON DELETE CASCADE,
    type                VARCHAR(50),
    date                DATE,
    commentaire_general TEXT
);

-- Table pour les questions d'evaluation
CREATE TABLE questions_evaluation
(
    id       SERIAL PRIMARY KEY,
    question TEXT,
    type     VARCHAR(50)
);

-- Table d'association entre les questions et les evaluations
CREATE TABLE association_question_evaluation
(
    id            SERIAL PRIMARY KEY,
    id_question   INT REFERENCES questions_evaluation (id),
    id_evaluation INT REFERENCES evaluations (id)
);

-- Table pour les réponses possibles (pour les QCM)
CREATE TABLE reponses_possibles
(
    id           SERIAL PRIMARY KEY,
    id_question  INT REFERENCES questions_evaluation (id) ON DELETE CASCADE,
    reponse      TEXT NOT NULL,
    est_correcte BOOLEAN DEFAULT FALSE
);

-- Table pour stocker les réponses aux questions
CREATE TABLE reponses_evaluation
(
    id                 SERIAL PRIMARY KEY,
    id_evaluation      INT REFERENCES evaluations (id) ON DELETE CASCADE,
    id_question        INT REFERENCES questions_evaluation (id),
    reponse_texte      TEXT,
    reponse_note       NUMERIC(5, 2),
    id_reponse_choisie INT REFERENCES reponses_possibles (id),
    commentaire        TEXT
);

-- Table employes
CREATE TABLE employes
(
    id            SERIAL PRIMARY KEY,
    id_candidat   INT REFERENCES candidats (id) ON DELETE CASCADE,
    date_embauche DATE NOT NULL,
    id_poste      INT REFERENCES postes (id),
    contrat_type  VARCHAR(50),
    salaire       NUMERIC(10, 2)
);

CREATE TABLE historique_performance_employe
(
    id                serial primary key,
    id_employes       int references employes (id) not null,
    score_competences DECIMAL,
    score_education   DECIMAL,
    score_experience  DECIMAL,
    performance       DECIMAL,
    date_mesure       timestamp
);

-- Tables pour les produits SaaS
CREATE TABLE saas_products
(
    id            SERIAL PRIMARY KEY,
    product_name  VARCHAR(255),
    description   TEXT,
    monthly_price numeric,
    annual_price  numeric
);

CREATE TABLE product_stocks
(
    stock_id       SERIAL PRIMARY KEY,
    product_id     INT REFERENCES saas_products (id) ON DELETE CASCADE,
    annee          NUMERIC NOT NULL CHECK (annee BETWEEN 2000 AND 2100),
    stock_quantity DECIMAL
);

-- Tables pour les abonnements
CREATE TABLE subscriptions_status
(
    id         SERIAL PRIMARY KEY,
    appelation VARCHAR(50)
);

CREATE TABLE subscriptions
(
    id                      SERIAL PRIMARY KEY,
    user_id                 INT REFERENCES users (id),
    product_id              INT REFERENCES saas_products (id),
    start_date              DATE,
    end_date                DATE,
    subscriptions_status_id INT REFERENCES subscriptions_status (id)
);

-- Tables pour la facturation
CREATE TABLE invoice_status
(
    id         SERIAL PRIMARY KEY,
    appelation VARCHAR(50)
);

CREATE TABLE invoices
(
    id                SERIAL PRIMARY KEY,
    subscription_id   INT REFERENCES subscriptions (id),
    total_amount      numeric,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    invoice_status_id INT REFERENCES invoice_status (id)
);

-- Tables pour le support
CREATE TABLE support_tickets_status
(
    id         SERIAL PRIMARY KEY,
    appelation VARCHAR(50)
);

CREATE TABLE support_tickets
(
    id                        SERIAL PRIMARY KEY,
    user_id                   INT REFERENCES users (id),
    sujet                     VARCHAR(255),
    description               TEXT,
    support_tickets_status_id INT REFERENCES support_tickets_status (id),
    created_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table pour les indicateurs financiers
CREATE TABLE financial_indicators
(
    indicator_id            SERIAL PRIMARY KEY,
    annee                   NUMERIC NOT NULL CHECK (annee BETWEEN 2000 AND 2100),
    total_assets            decimal,
    current_assets          decimal,
    fixed_assets            decimal,
    total_liabilities       decimal,
    current_liabilities     decimal,
    non_current_liabilities decimal,
    equity                  decimal,
    revenue                 decimal,
    operating_expenses      decimal,
    net_profit              decimal,
    roa                     decimal,
    roe                     decimal,
    liquidity_ratio         decimal,
    quick_ratio             decimal
);

-- Modification de la table candidate pour lier aux utilisateurs
ALTER TABLE candidats
    ADD COLUMN user_id INT REFERENCES users (id);

-- Modification de la table employes pour lier aux utilisateurs
ALTER TABLE employes
    ADD COLUMN user_id INT REFERENCES users (id);

-- Fonction de calcul des indicateurs financiers
CREATE
    OR REPLACE FUNCTION before_insert_financial_indicators()
    RETURNS TRIGGER AS
$$
DECLARE
    stock_value FLOAT;
BEGIN
    SELECT COALESCE(SUM(ps.stock_quantity), 0)
    INTO stock_value
    FROM product_stocks ps
    WHERE ps.annee = NEW.annee;

    NEW
        .
        roa
        := (NEW.net_profit / NULLIF(NEW.total_assets, 0)) * 100;
    NEW.roe
        := (NEW.net_profit / NULLIF(NEW.equity, 0)) * 100;
    NEW.liquidity_ratio
        := (NEW.current_assets / NULLIF(NEW.current_liabilities, 0));
    NEW.quick_ratio
        := ((NEW.current_assets - stock_value) / NULLIF(NEW.current_liabilities, 0));

    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;

-- Trigger pour les indicateurs financiers
CREATE TRIGGER trg_calculate_indicators
    BEFORE INSERT OR
        UPDATE
    ON financial_indicators
    FOR EACH ROW
EXECUTE FUNCTION before_insert_financial_indicators();

-- Données initiales pour les statuts
INSERT INTO subscriptions_status (appelation)
VALUES ('Active'),
       ('Suspended'),
       ('Expired');

INSERT INTO invoice_status (appelation)
VALUES ('Paid'),
       ('Pending'),
       ('Cancelled');

INSERT INTO support_tickets_status (appelation)
VALUES ('Open'),
       ('In Progress'),
       ('Closed');