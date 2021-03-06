// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package fr.taouf.sample_taouf.dagger.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;

public final class NetworkModule_FileFactory implements Factory<File> {
  private final NetworkModule module;

  private final Provider<Context> contextProvider;

  public NetworkModule_FileFactory(NetworkModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public File get() {
    return Preconditions.checkNotNull(
        module.file(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<File> create(NetworkModule module, Provider<Context> contextProvider) {
    return new NetworkModule_FileFactory(module, contextProvider);
  }
}
