package com.li.shorty;


public class Fuck {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Fuck.class);
  private String msg;

  public Fuck() {
  }

  public static void main(String[] args) {
    Fuck fuck = new Fuck();
    fuck.getMsg();
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Fuck)) {
      return false;
    }
    final Fuck other = (Fuck) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$msg = this.getMsg();
    final Object other$msg = other.getMsg();
    if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) {
      return false;
    }
    return true;
  }

  public String getMsg() {
    return this.msg;
  }

  @Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $msg = this.getMsg();
    result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
    return result;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Fuck(msg=" + this.getMsg() + ")";
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Fuck;
  }
}
