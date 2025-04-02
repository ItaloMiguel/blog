package br.com.blog.site.shared.infra;

public interface Mapper <S, T> {
    T map(S source);
}
