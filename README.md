# java_base
Java基础知识

1. 集合
   1. [Properties：配置文件](src/main/java/com/pengo/collection/properties)
      
      Properties prop = new Properties()
   
      prop.load(new FileInputStream())   //绝对路径
   
      prop.load(this.getClass().getResourceAsStream())   //路径要"/"打头
   
      prop.getProperties()
      
      prop.setProperties()
      
      porp.store(new FileOutStream())
   2. [Queue:队列](src/main/java/com/pengo/collection/queue/QueueDemo.java)

      先进先出的队列（FIFO：first in first out）
   
      |                | throw Exception  | true/false  |
      |  ----          | ----             |----         |
      | 添加元素到队尾    | add(E e)        |offer(E e)   |
      | 获取首元素并删除  | E remove(E e)   |poll()       |
      | 获取首元素不删除  | E element()     |peek()       |
   3. [PriorityQueue:优先级队列](src/main/java/com/pengo/collection/queue/PriorityQueueDemo.java)
   
      通过Comparable决定顺序
   4. [Deque：双端队列](src/main/java/com/pengo/collection/queue/DequeDemo.java)
   
      添加到队首：addFirst(E e)/offFirst(E e)
   
      取队首并删除：E removeFirst()/E pollFirst()
   
      取队首不删除：E getFirst()/E peekFirst()
   
      添加到队尾：addLast(E e)/offLast(E e)
   
      取队尾并删除：E removeLast()/E pollLast()
   
      取队尾不删除：E getLast()/E peekLast()
   5. [Stack:栈](src/main/java/com/pengo/collection/stack)
      
      后进先出的队列（LIFO：last in first out）

      压栈：push(E e)

      弹出：E pop()

      取栈顶但不弹出：E peek()
   6. [Iterator:集合迭代器](src/main/java/com/pengo/collection/iterator)

      简单迭代器：
   
      集合实现Iterable，内部类实现Iterator.
   7. [Collections:JDK提供的集合工具类](src/main/java/com/pengo/collection/collections)

      创建空集合（immutable）：Collections.emptyList()

      创建单集合（immutable）：Collections.singletonList(E e)

      集合排序：Collections.sort(list)

      打乱集合：Collections.shuffle(list)

      不可变集合：newList = Collections.unmodifiableList(list)--->虽然newList不可变，但改变list同样会引起newList的变化，所有要把list=null

      tips: List.of()创建的集合为immutable集合（不可变集合）