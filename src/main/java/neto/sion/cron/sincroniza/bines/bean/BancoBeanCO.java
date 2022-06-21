/* Decompiler 3ms, total 77ms, lines 36 */
package neto.sion.cron.sincroniza.bines.bean;

public class BancoBeanCO extends BancoBean {
   private float comision;
   private String imagenBanco;
   private int limiteRetiro;

   public float getComision() {
      return this.comision;
   }

   public void setComision(float comision) {
      this.comision = comision;
   }

   public String getImagenBanco() {
      return this.imagenBanco;
   }

   public void setImagenBanco(String imagenBanco) {
      this.imagenBanco = imagenBanco;
   }

   public int getLimiteRetiro() {
      return this.limiteRetiro;
   }

   public void setLimiteRetiro(int limiteRetiro) {
      this.limiteRetiro = limiteRetiro;
   }

   public String toString() {
      return "BancoBeanCO [comision=" + this.comision + ", imagenBanco=" + this.imagenBanco + ", limiteRetiro=" + this.limiteRetiro + "]";
   }
}
