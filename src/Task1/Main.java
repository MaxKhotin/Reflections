package Task1;

//Создайте класс Cat с двумя полями: name и age и обязательным методом sayMeow()
//        - выведите информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах
//        - получите и установите значение полей объекта по имени
//        - вызовите метод объекта sayMeow() по имени


import java.lang.reflect.Constructor;
import java.lang.reflect.*;

public class Main {

    class Cat {
        private String name;
        private int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private void sayMeow () {
            System.out.println("Meow");
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Class cl = Cat.class;

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + fieldType.getName());
        }

        System.out.println("--------------------------------------------------");


        Constructor [] cnstr = cl.getConstructors();
        for (Constructor ctr : cnstr) {
            Class [] parameterTypes = ctr.getParameterTypes();
            for (Class parTypes : parameterTypes) {
                System.out.println("Name: " + parTypes.getName());
            }
        }
        for (Constructor ctr : cnstr) {
            System.out.println(ctr.getName());
        }


        int mods = cl.getModifiers();
        if (Modifier.isPrivate(mods)) {
            System.out.println("private");
        }
        if (Modifier.isProtected(mods)) {
            System.out.println("protected");
        }
        if (Modifier.isPublic(mods)) {
            System.out.println("public");
        }
        System.out.println();

    }
}