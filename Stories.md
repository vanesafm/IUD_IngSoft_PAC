


|HISTORIA DE USUARIO | NO.1   |
| ----------- | ----------- |
| Usuario | Empleado |
| Nombre Historia  | Ingreso de Vehiculo|
| Prioridad en negocio | alta |
| Riesgo en desarrollo | Baja |
| Puntos estimados |  |
| Iteracion asignada | 1 |
| Programador Responsable | Vanesa |
## Descripcion 
Como empleado del parqueadero necesito consignar la informacion referente al vehiculo que va a ingresar al parqueadero, incluyendo placa y Observaciones (si aplica).

## Validacion 
Revision Periodica en la tabla de registros 

---

---

|HISTORIA DE USUARIO | NO.2 |
| ----------- | ----------- |
| Usuario | Empleado |
| Nombre Historia  | Liquidacion de servicio contrato ocasional |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como empleado requiero calcular la tarifa del servicio prestado para contratos ocasionales, tomando la fecha+hora de ingreso del vehiculo y la fecha+hora de salida, con este calculo obtengo el valor del tiempo a cobrar por el parqueadero del contrato ocasional.

## Validacion 

La tarifa calculada debe corresponder con el tiempo de servicio dentro del parqueadero y con la tarifa . 

---

---

|HISTORIA DE USUARIO | NO.3 |
| ----------- | ----------- |
| Usuario | Empleado |
| Nombre Historia  | Liquidacion de servicio contrato mensual|
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como empleado requiero llevar conteo  de los dias del servicio prestados para contratos mensuales, tomando la fecha de pago anticipado como inicio y la fecha de terminacion 30 dias despues, con este calculo obtengo los dias proximos a vencer la mensualidad. 

## Validacion 

La dias de conteo debe corresponder con el tiempo de servicio desde el dia 1 donde se paga anticipadamente  la tarifa acordada hasta el dia 30 dia de vencimiento. 

---

---


|HISTORIA DE USUARIO | NO. 4  |
| ----------- | ----------- |
| Usuario | Empleado |
| Nombre Historia  | Registro de salida |
| Prioridad en negocio | Alta |
| Riesgo en desarrollo | Baja |
| Puntos estimados |  |
| Iteracion asignada | 1 |
| Programador Responsable | Vanesa |
## Descripcion 
Como empleado debo consignar la informacion referente al vehiculo que va a salir del parqueadero, incluyendo placa y Observaciones (si aplica).

## Validacion 
Revision Periodica en la tabla de registros 

---

---

|HISTORIA DE USUARIO | NO. 5 |
| ----------- | ----------- |
| Usuario | Empleado |
| Nombre Historia  | Autorizar salida del vehiculo |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | Bajo |
| Puntos estimados |  |
| Iteracion asignada | 1|
| Programador Responsable | Vanesa |
## Descripcion 

Como empleado del parqueadero debo permitir y autorizar la salida del vehiculo desde el parqueadero una vez  halla cancelado la tarifa pactada


## Validacion 
Validar pago del servicios prestado 

---

---
|HISTORIA DE USUARIO | NO.6 |
| ----------- | ----------- |
| Usuario | Administrador|
| Nombre Historia  | Creacion de usuarios |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, requiero crear usuarios para que los encargados del parqueadero ingresen y usen el sistema


## Validacion 

El usuario debe ingresar con usuario y contraasena la sistema, validados por la coincidencia en los datos registrados en el sistema 
(numero de cedual y contrasena)


|HISTORIA DE USUARIO | NO.7 |
| ----------- | ----------- |
| Usuario | Administrador|
| Nombre Historia  | Creacion de roles |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, requiero crear  roles de usuarios para establecer permisos y usos del sistema

## Validacion 

Rol Administrador  en el sistema 
Rol usuario en el sistema (encargado del parqueadero)

---
|HISTORIA DE USUARIO | NO.8 |
| ----------- | ----------- |
| Usuario | Administrador|
| Nombre Historia  | Actualizacion de usuarios  |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, requiero actualizar la informacion de los encargados del parqueadero para cusodiar 
la informacion veridica y real.


## Validacion 

El sistem permitira cambiar datos  de los usuarios encargados. 
---


|HISTORIA DE USUARIO | NO.9 |
| ----------- | ----------- |
| Usuario | Administrador|
| Nombre Historia  | Creacion estados de usuarios  |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, requiero crear estados de usuarios para validar quien esta activo o inactivo en el sistema 


## Validacion 

Los usuarios inactivos no podran ingresar al sistema 
Los uaurios activos podran  ingresar y usar el sistema acorde con sus credenciales. 

---


|HISTORIA DE USUARIO | NO.10 |
| ----------- | ----------- |
| Usuario | usuarios encargado del parqueadero|
| Nombre Historia  | Acceso al sistema |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como encargado del parqueadero, requiero que el sistema me permita ingresar al sistema 

## Validacion 

Logueo exitoso, datos de usuaro y contrsena coinciden con los reportados en el sistema. 


---


|HISTORIA DE USUARIO | NO.11 |
| ----------- | ----------- |
| Usuario | usuarios encargado del parqueadero|
| Nombre Historia  | Consultar disponibilidad de celda |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como encargado del parqueadero, quiero ver la disponibilidad de celdas  en el sistema, para asignar celdas a vehiculos que ingresen. 

## Validacion 

Alerta del sistema que indique que se agotaron las celdas disponibles.  



|HISTORIA DE USUARIO | NO.12 |
| ----------- | ----------- |
| Usuario | usuarios encargado del parqueadero|
| Nombre Historia  | Cambio de estado de celdas |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como encargado del parqueadero, debo modificar el estado de las celdas cuando ingrese o salga un vehiculo del parqueadero para liberar 
u ocupar las celdas del inventario de celdas. 

## Validacion 

Estados de celdas creados y dispuestos para cambiar su estado (disponible, Ocupado, No disponible)
Las celdas ocupadas por contratos mensuales, deberan aparecer no disponibles. 


|HISTORIA DE USUARIO | NO.13 |
| ----------- | ----------- |
| Usuario | Administrador |
| Nombre Historia  | Creacion plantilla inventario de celdas |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, debo crear la plantilla deinventario de celdas  para que las celdas puedan ser creadas e identificadas, y
el usuario encargado modificar su estado.

## Validacion 

Plantilla de celdas creadas

|HISTORIA DE USUARIO | NO.14 |
| ----------- | ----------- |
| Usuario | Administrador |
| Nombre Historia  | Creacion de celdas |
| Prioridad en negocio | 1 |
| Riesgo en desarrollo | medio |
| Puntos estimados | |
| Iteracion asignada | 2 |
| Programador Responsable | Vanesa |
## Descripcion 

Como administrador del sistema, debo crear las celdas para alimentar la plantilla de inventario de celdas y que estas sean usadas. 

## Validacion 
Celdas creadas en la plantilla de inventario de celdas. 
