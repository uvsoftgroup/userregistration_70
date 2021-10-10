ALTER TABLE if exists user_registration_role
DROP CONSTRAINT fk_user_role_registration,
ADD  CONSTRAINT fk_user_role_registration  FOREIGN KEY (urr_ur_id) REFERENCES user_registration
ON DELETE CASCADE;


