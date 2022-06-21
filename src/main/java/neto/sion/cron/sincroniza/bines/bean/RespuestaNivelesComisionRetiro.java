/* Decompiler 1ms, total 103ms, lines 20 */
package neto.sion.cron.sincroniza.bines.bean;

import java.util.Arrays;

public class RespuestaNivelesComisionRetiro {
   private NivelComisionBean[] nivelesComisiones;

   public NivelComisionBean[] getNivelesComisiones() {
      return this.nivelesComisiones;
   }

   public void setNivelesComisiones(NivelComisionBean[] nivelesComisiones) {
      this.nivelesComisiones = nivelesComisiones;
   }

   public String toString() {
      return "RespuestaNivelesComisionRetiro [nivelesComisiones=" + Arrays.toString(this.nivelesComisiones) + "]";
   }
}
