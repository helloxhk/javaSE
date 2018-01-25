package com.test.keywords;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 1、Serializable序列化时不会调用默认的构造器，而Externalizable序列化时会调用默认构造器的！！！
 * 
 * 2、Serializable：一个对象想要被序列化，那么它的类就要实现
 * 此接口，这个对象的所有属性（包括private属性、包括其引用的对象）都可以被序列化和反序列化来保存、传递。
 * Externalizable：他是Serializable接口的子类，有时我们不希望序列化那么多，可以使用这个接口，这个接口的writeExternal(
 * )和readExternal()方法可以指定序列化哪些属性。 注意：
 * 对象的序列化并不属于新的Reader和Writer层次结构的一部分，而是沿用老式的InputStream和OutputStream结构，在某些情况下，
 * 不得不混合使用两种类型的层次结构。
 * 恢复了一个反序列化的对象后，如果想对其做更多的事情（对象.getClass().xxx），必须保证JVM能在本地类路径或者因特网的其他什么地方找到相关的.
 * class文件。 恢复对象的默认构建器必须是public的，否则会抛异常。
 * 由于Externalizable对象默认时不保存对象的任何字段，所以transient关键字只能伴随Serializable使用，
 * 虽然Externalizable对象中使用transient关键字也不报错，但不起任何作用。 
 * 
 * 3、把transient修饰的字段序列化
 * 方法writeObject处理对象的序列化。如果声明该方法，它将会被ObjectOutputStream调用而不是默认的序列化进程。如果你是第一次看见它，
 * 你会很惊奇尽管它们被外部类调用但事实上这是两个private的方法。并且它们既不存在于java.lang.Object，
 * 也没有在Serializable中声明。那么ObjectOutputStream如何使用它们的呢？这个吗，
 * ObjectOutputStream使用了反射来寻找是否声明了这两个方法。因为ObjectOutputStream使用getPrivateMethod(
 * 通过getDeclareMethod可以获得私有方法），所以这些方法不得不被声明为private以至于供ObjectOutputStream来使用。
 * 在两个方法的开始处，你会发现调用了defaultWriteObject()和defaultReadObject()。它们做的是默认的序列化进程，就像写/
 * 读所有的non-transient和
 * non-static字段(但他们不会去做serialVersionUID的检查).通常说来，所有我们想要自己处理的字段都应该声明为transient。
 * 这样的话，defaultWriteObject/defaultReadObject便可以专注于其余字段，而我们则可为这些特定的字段(译者：
 * 指transient)定制序列化。使用那两个默认的方法并不是强制的，而是给予了处理复杂应用时更多的灵活性。
 * 
 * @author xhk
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -889893399192500563L;

	private String username;
	private transient String password;

	/**
	 * 方法名必需这样写。
	 * 会被ObjectInputStream调用
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		password = (String) ois.readObject();
	}

	/**
	 * 方法名必需这样写。
	 * 会被ObjectOutputStream调用
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
