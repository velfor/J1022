CREATE TABLE patients(
    id IDENTITY PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    diagnosis VARCHAR(100),
    dateOfAdmission DATE NOT NULL,
    dateOfDischarge DATE
);