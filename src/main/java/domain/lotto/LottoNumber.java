package domain.lotto;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private static final LottoNumber[] CACHE = IntStream.rangeClosed(MIN, MAX)
                                                        .mapToObj(LottoNumber::new)
                                                        .toArray(LottoNumber[]::new);

    private final int val;

    public static LottoNumber of(int i) {
        if (i < MIN || i > MAX) {
            throw new IllegalArgumentException();
        }
        return CACHE[i - 1];
    }

    private LottoNumber(int i) {
        this.val = i;
    }

    @Override
    public int compareTo(LottoNumber rhs) {
        return this.val - rhs.val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        final LottoNumber rhs = (LottoNumber) o;
        return this.val == rhs.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.val);
    }
}