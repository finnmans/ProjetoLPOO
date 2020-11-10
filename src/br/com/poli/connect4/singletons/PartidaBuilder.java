package br.com.poli.connect4.singletons;

import br.com.poli.connect4.Partida;

public final class PartidaBuilder {
  private static PartidaBuilder INSTANCE = null;
  private final String[] UserNames;
  
  public PartidaBuilder(){ 
    UserNames = new String[]{"",""};
  }

  public static PartidaBuilder getInstance()
  {
    if (INSTANCE == null) {
      System.out.println("[PartidaBuilder] Inicializando");
      INSTANCE = new PartidaBuilder();
    }
    return INSTANCE;
  }

  public void setUserName(String name, int index){
    this.UserNames[index] = name;
  }
  
  public String getUserName(int index){
    return this.UserNames[index];
  }
  
  public Partida MakePartida() {
    if(UserNames[0].isEmpty() || UserNames[1].isEmpty()){
      throw new NullPointerException("É preciso definir o nome dos dois jogadores");
    }
    
    return new Partida(UserNames[0],UserNames[1]);
  }
}
