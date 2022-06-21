/* Decompiler 1ms, total 87ms, lines 12 */
package neto.sion.cron.sincroniza.bines.bean;

public class PeticionTienda extends PeticionAvisoReporteBean {
   public PeticionTienda() {
   }

   public PeticionTienda(int paisId, int tiendaId) {
      super.setPais(paisId);
      super.setTienda(tiendaId);
   }
}
