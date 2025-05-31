package io.github.urusso.springbootexample.config.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.urusso.springbootexample.common.constants.CacheName;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class CacheManagerConfig {
    private final CacheConfiguration cacheConfig;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCache jwtCache = new CaffeineCache(CacheName.JWT_CACHE,
                Caffeine.newBuilder()
                        .expireAfterWrite(cacheConfig.getJwtTtl(), TimeUnit.MINUTES)
                        .maximumSize(2)
                        .build()
        );

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(jwtCache));

        return manager;
    }
}
