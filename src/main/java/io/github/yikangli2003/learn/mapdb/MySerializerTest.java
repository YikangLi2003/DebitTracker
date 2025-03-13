package io.github.yikangli2003.learn.mapdb;

import org.jetbrains.annotations.NotNull;
import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.Serializer;

import java.io.IOException;

public class MySerializerTest {
    private class Fruit {
        public String name;
        public double weight;

        public Fruit(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        public String toString() {
            return "Fruit{name='" + name + "', weight=" + weight + "}";
        }
    }

    private class UserSerializer implements Serializer<Fruit> {
        @Override
        public void serialize(@NotNull DataOutput2 dataOutput2, @NotNull Fruit fruit) throws IOException {

        }

        @Override
        public Fruit deserialize(@NotNull DataInput2 dataInput2, int i) throws IOException {
            return null;
        }
    }
}
