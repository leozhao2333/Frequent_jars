package com.ziggeo.androidsdk;

import android.content.Context;
import androidx.annotation.NonNull;

import java.io.File;

/**
 * Created by Alex Bedulin on 20-Mar-18.
 */
public class CacheConfig {

    private File cacheRoot;
    private long maxCacheSize;

    private CacheConfig(@NonNull File cacheRoot, long maxCacheSize) {
        this.cacheRoot = cacheRoot;
        this.maxCacheSize = maxCacheSize;
    }

    public static CacheConfig getDefault(@NonNull Context context) {
        return new CacheConfig.Builder(context).build();
    }

    @NonNull
    public File getCacheRoot() {
        return cacheRoot;
    }

    public long getMaxCacheSize() {
        return maxCacheSize;
    }

    /**
     * Builder for {@link CacheConfig}.
     */
    public static final class Builder {
        static final long DEFAULT_MAX_CACHE_SIZE = 1024 * 1024 * 1024L; // 1Gb

        private File cacheRoot;
        private long maxCacheSize;

        public Builder(@NonNull Context context) {
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(context);
            this.maxCacheSize = DEFAULT_MAX_CACHE_SIZE;
        }

        /**
         * Overrides default cache folder to be used for caching files.
         * <p>
         * By default AndroidVideoCache uses
         * '/Android/data/[app_package_name]/cache/video-cache/' if card is mounted and app has appropriate permission
         * or 'video-cache' subdirectory in default application's cache directory otherwise.
         * </p>
         * <b>Note</b> directory must be used <b>only</b> for AndroidVideoCache files.
         *
         * @param file a cache directory, can't be null.
         * @return a builder.
         */
        public Builder cacheDirectory(@NonNull File file) {
            this.cacheRoot = file;
            return this;
        }

        /**
         * Sets max cache size in bytes.
         * <p>
         * All files that exceeds limit will be deleted using LRU strategy.
         * Default value is 512 Mb.
         *
         * @param maxSize max cache size in bytes.
         * @return a builder.
         */
        public Builder maxCacheSize(long maxSize) {
            this.maxCacheSize = maxSize;
            return this;
        }

        public CacheConfig build() {
            return new CacheConfig(cacheRoot, maxCacheSize);
        }
    }
}