DROP DATABASE IF EXISTS mealers_choice;
CREATE DATABASE mealers_choice;

CREATE TABLE recipe (
  recipe_id INT               AUTO_INCREMENT,
  flavor    ENUM('salty',
    'sour',
    'sweet',
    'bitter',
    'savory')                 NOT NULL,
  texture   ENUM('crumbly',
    'soft',
    'creamy',
    'tender'
    'chewy'
    'crispy',
    'crispy',
    'moist',
    'flakey')                 NOT NULL,
  type      ENUM('breakfast',
    'lunch',
    'dinner',
    'appetizer',
    'dessert',
    'snack')                  NOT NULL,
  time      ENUM('15min',
    '30min',
    '45min',
    '1hr',
    '1hr15min',
    '1hr30min',
    '1hr45min',
    '2hr',
    '2hr+')                   NOT NULL,
  CONSTRINAT recipePK
    PRIMARY KEY (recipe_id)
) ENGINE INNODB
;

CREATE TABLE recipe_line (
  recipe_id   INT             NOT NULL,
  recipe_line INT             NOT NULL,
  line        VARCHAR(100)    NOT NULL,
  CONSTRAINT recipe_linePK
    PRIMARY KEY (recipe_id, recipe_line),
  CONSTRAINT recipe_line_fk_recipe
    FOREIGN KEY (recipe_id)
    REFERENCES recipe (recipe_id)
) ENGINE INNODB
;

CREATE TABLE common_allergen (
  recipe_id         INT       NOT NULL,
  common_allergen   ENUM('milk',
    'eggs',
    'fish',
    'tree nuts',
    'peanuts',
    'wheat',
    'soy',
    'shellfish'
    'sesame')                 NOT NULL,
  CONSTRAINT common_allergenPK
    PRIMARY KEY (recipe_id, common_allergen),
  CONSTRAINT common_allergen_fk_recipe
    FOREIGN KEY (recipe_id)
    REFERENCES recipe (recipe_id)
) ENGINE INNODB
;

CREATE TABLE user (
  username VARCHAR(45)      NOT NULL,
  password VARCHAR(45)      NOT NULL,
  CONSTRAINT userPK
    PRIMARY KEY (username)
) ENGINE INNODB
;

CREATE TABLE favorite (
  username  VARCHAR(45)     NOT NULL,
  recipe_id INT             NOT NULL,
  CONSTRAINT favoritePK
    PRIMARY KEY (username, recipe_id),
  CONSTRAINT favorite_fk_user
    FOREIGN KEY (username)
    REFERENCES user (username),
  CONSTRAINT favorite_fk_recipe
    FOREIGN KEY (recipe_id)
    REFERENCES recipe (recipe_id)
) ENGINE INNODB
;
