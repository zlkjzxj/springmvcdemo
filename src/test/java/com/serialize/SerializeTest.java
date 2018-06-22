package com.serialize;

import com.bean.FlyPig;
import org.junit.Test;

import java.io.*;

public class SerializeTest {
    /**
     * 1、序列化是干什么的？
     简单说就是为了保存在内存中的各种对象的状态，并且可以把保存的对象状态再读出来。虽然你可以用你自己的各种各样的方法来保存Object States，但是Java给你提供一种应该比你自己好的保存对象状态的机制,那就是序列化。
     2、什么情况下需要序列化
     a）当你想把的内存中的对象保存到一个文件中或者数据库中时候；
     b）当你想用套接字在网络上传送对象的时候；
     c）当你想通过RMI传输对象的时候；
     * @throws IOException
     */

    @Test
    /**
     * 1.实体不继承序列化接口就会报错
     * 2.当你不给实体添加属性时，他的序列化和反序列化是正常的，
     * 但是当你先序列化，然后再添加一个属性之后再反序列化时，他就报错了，说两次serialVersionUID 不一样
     * 这是因为你没添加属性序列化的值和添加完属性之后系统默认序列化的值发生了变化！
     * 3.当你给他添加序列化值之后这种情况就消失了！因为两次的序列化值都是你自己定义得
     *
     * 下面是摘自 jdk api 文档里面关于接口 Serializable 的描述
     类通过实现 java.io.Serializable 接口以启用其序列化功能。
     未实现此接口的类将无法使其任何状态序列化或反序列化。
     可序列化类的所有子类型本身都是可序列化的。因为实现接口也是间接的等同于继承。
     序列化接口没有方法或字段，仅用于标识可序列化的语义。

     关于 serialVersionUID 的描述
     序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联
     ，该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。
     如果接收者加载的该对象的类的 serialVersionUID 与对应的发送者的类的版本号不同，
     则反序列化将会导致 InvalidClassException。可序列化类可以通过声明名为 "serialVersionUID" 的字段（该字段必须是静态 (static)、最终 (final)
     的 long 型字段）显式声明其自己的 serialVersionUID：

     如果可序列化类未显式声明 serialVersionUID，
     则序列化运行时将基于该类的各个方面计算该类的默认 serialVersionUID 值，如“Java(TM) 对象序列化规范”中所述。
     不过，强烈建议 所有可序列化类都显式声明 serialVersionUID 值，原因是计算默认的 serialVersionUID 对类的详细信息具有较高的敏感性，
     根据编译器实现的不同可能千差万别，这样在反序列化过程中可能会导致意外的 InvalidClassException。因此，
     为保证 serialVersionUID 值跨不同 java 编译器实现的一致性，序列化类必须声明一个明确的 serialVersionUID 值。
     还强烈建议使用 private 修饰符显示声明 serialVersionUID（如果可能），原因是这种声明仅应用于直接声明类 -- serialVersionUID
     字段作为继承成员没有用处。数组类不能声明一个明确的 serialVersionUID，因此它们总是具有默认的计算值，但是数组类没有匹配 serialVersionUID
     值的要求
     */
    public void SerializePig() throws IOException {
        FlyPig pig = new FlyPig();
        pig.setName("auto");
        pig.setColor("Red");
        pig.setCar("audi");

        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("F:/test.txt")));
        stream.writeObject(pig);
        stream.close();
    }

    @Test
    public void desSerializePig() throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("F:/test.txt")));
        FlyPig flyPig = (FlyPig) stream.readObject();
        System.out.println(flyPig.toString());
        stream.close();
    }
}
