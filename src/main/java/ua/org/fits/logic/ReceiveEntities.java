package ua.org.fits.logic;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiveEntities<T,K> {
    List<T> get(K val);
}
