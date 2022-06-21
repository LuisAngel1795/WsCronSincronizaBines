/* Decompiler 2ms, total 79ms, lines 18 */
package neto.sion.cron.sincroniza.bines.bean;

public class BinBeanCo extends BinBean {
   private int indicaRetiroCO;

   public int getIndicaRetiroCO() {
      return this.indicaRetiroCO;
   }

   public void setIndicaRetiroCO(int indicaRetiroCO) {
      this.indicaRetiroCO = indicaRetiroCO;
   }

   public String toString() {
      return "BinBeanCo [Banco=" + super.getFiBancoId() + ",Bin=" + super.getFiBinesId() + ",Origen=" + super.getFiOrigenId() + ",TipoTarjeta=" + super.getFiTipoTarjetaId() + "indicaRetiroCO=" + this.indicaRetiroCO + "]";
   }
}
