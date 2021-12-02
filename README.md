# java_base
Java基础知识

1. 集合
   1. Properties
      
      Properties prop = new Properties()
   
      prop.load(new FileInputStream())   //绝对路径
   
      prop.load(this.getClass().getResourceAsStream())   //路径要"/"打头
   
      prop.getProperties()
      
      prop.setProperties()
      
      porp.store(new FileOutStream())