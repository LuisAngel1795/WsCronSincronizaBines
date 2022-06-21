
package neto.sion.cron.sincroniza.bines.controlador;

import neto.sion.cron.sincroniza.bines.bean.ConfiguracionBaseRetiroBean;
import neto.sion.cron.sincroniza.bines.bean.PeticionTienda;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBancoBeanCO;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBinBeanCo;
import neto.sion.cron.sincroniza.bines.bean.RespuestaNivelesComisionRetiro;
import neto.sion.cron.sincroniza.bines.dao.ConfiguracionesDao;
import org.apache.axis2.AxisFault;

public class ConfiguracionesController {
   private ConfiguracionesDao configuracionesDao = new ConfiguracionesDao();

   public RespuestaBancoBeanCO obtenerBancosCO(PeticionTienda _peticion) throws AxisFault {
      return this.configuracionesDao.respuestaBancoCOBean(_peticion);
   }

   public RespuestaBinBeanCo respuestaBinCoBean() throws AxisFault {
      return this.configuracionesDao.respuestaBinCoBean();
   }

   public ConfiguracionBaseRetiroBean obtenerIpAncladaEstatusRetiro(PeticionTienda _peticion) throws AxisFault {
      return this.configuracionesDao.obtenerIpAncladaEstatusRetiro(_peticion);
   }

   public RespuestaNivelesComisionRetiro consultaNivelesComisionesRetiro(PeticionTienda _peticion) throws AxisFault {
      return this.configuracionesDao.consultaNivelesComisionesRetiro(_peticion);
   }
}
