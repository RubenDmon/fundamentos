SELECT * FROM plan;
SELECT * FROM usuario;
SELECT * FROM cuenta;
SELECT * FROM viaje;

--relacion user plan
SELECT * FROM plan_cuenta;

--insertar viaje iniciando mirando si el estado es activo
INSERT INTO viaje (k_idviaje,k_codigo,o_horainicial)VALUES(1,1,CURRENT_TIME);
--actualizar el viaje para acabarlo y cobrar
UPDATE viaje SET o_horafinal = CURRENT_TIME, o_duracion=12,v_costo=12000 WHERE k_idviaje = 1;
--ponerle el min adicional
UPDATE viaje SET o_minadicional =12 WHERE k_idviaje = 1;
UPDATE cuenta SET v_saldo=v_saldo-25 WHERE k_codigo=1 ;
--se pone un condicional si el saldo es negativo el usuario no puede viajar
UPDATE cuenta SET o_estado='UACT' k_codigo=1 ;