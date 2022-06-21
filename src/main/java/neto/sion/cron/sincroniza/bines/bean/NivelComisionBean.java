/* Decompiler 6ms, total 87ms, lines 54 */
package neto.sion.cron.sincroniza.bines.bean;

public class NivelComisionBean {
   private int limiteId;
   private float comision;
   private float importeMinVenta;
   private float importeMaxVenta;
   private int estatus;

   public int getLimiteId() {
      return this.limiteId;
   }

   public void setLimiteId(int limiteId) {
      this.limiteId = limiteId;
   }

   public float getComision() {
      return this.comision;
   }

   public void setComision(float comision) {
      this.comision = comision;
   }

   public float getImporteMinVenta() {
      return this.importeMinVenta;
   }

   public void setImporteMinVenta(float importeMinVenta) {
      this.importeMinVenta = importeMinVenta;
   }

   public float getImporteMaxVenta() {
      return this.importeMaxVenta;
   }

   public void setImporteMaxVenta(float importeMaxVenta) {
      this.importeMaxVenta = importeMaxVenta;
   }

   public int getEstatus() {
      return this.estatus;
   }

   public void setEstatus(int estatus) {
      this.estatus = estatus;
   }

   public String toString() {
      return "NivelComisionBean [limiteId=" + this.limiteId + ", comision=" + this.comision + ", importeMinVenta=" + this.importeMinVenta + ", importeMaxVenta=" + this.importeMaxVenta + ", estatus=" + this.estatus + "]";
   }
}
