package io.github.yikangli2003.test.jackson;

import java.io.Serializable;

public record Store(String name, int id, Address address) implements Serializable {
}
