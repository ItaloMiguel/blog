package br.com.blog.cursinho.shared.infra;

public interface Mapper <S, T> {
    T map(S source);
}
