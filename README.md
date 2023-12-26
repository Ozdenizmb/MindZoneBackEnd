# MindZoneBackEnd

Sign Up işlemi için path:
/api/v1/users
RequestBody = UserCreateDto

Login işlemi için path:
/api/v1/users/{userLoginDto}
RequestBody = UserLoginDto



SQL create Database

CREATE TABLE charity_admins (
id uuid DEFAULT uuid_generate_v4(),
first_name VARCHAR NOT NULL,
last_name VARCHAR NOT NULL,
email VARCHAR NOT NULL,
password VARCHAR NOT NULL,
phone_number VARCHAR NOT NULL,
age int NOT NULL,
gender VARCHAR NOT NULL,
education VARCHAR NOT NULL,
financial_situation VARCHAR NOT NULL,
chronic_disease VARCHAR NOT NULL,
psychology VARCHAR NOT NULL,
PRIMARY KEY (id));
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
