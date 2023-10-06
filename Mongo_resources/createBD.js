/* Schema para crear la base de Datos
 * El layout proviene del servicio de la pagina de compranet 
 * https://datos.gob.mx/blog/catalogo-apidatosgobmx
    Compranet API : GET https://api.datos.gob.mx/v1/compranet
    Consulta la información del sistema de Compranet, cada elemento de la respuesta contendrá información sobre:
    --Dependencia
    --Responsable
    --Titulo, plantilla y numero del expediente
    --Tipo de contratación
    --Código, titulo e importe del contrato
    --Fecha de incio y de termino
    --Liga de acceso
 */

use admin;
db.createUser(
{
	user: "uc_owner",
	pwd: "uc_password",
	roles: [
      { role: "userAdmin", db: "seguimientoucdb"
      }
   ]
});
use seguimientoucdb;

