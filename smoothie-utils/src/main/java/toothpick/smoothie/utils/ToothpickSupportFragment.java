package toothpick.smoothie.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;
import toothpick.smoothie.annotations.FragmentSingleton;
import toothpick.smoothie.module.ToothpickSupportFragmentModule;

public class ToothpickSupportFragment extends Fragment {
  private Scope scope;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    Activity activity = getActivity();

    scope = Toothpick.openScopes(activity.getApplication(), activity, this);

    scope.bindScopeAnnotation(FragmentSingleton.class);

    scope.installModules(new ToothpickSupportFragmentModule(this));
    Module[] modules = provideModulesForInstallation();
    if(modules != null) {
      scope.installModules(modules);
    }
    super.onCreate(savedInstanceState);
    Toothpick.inject(this, scope);
  }

  protected Module[] provideModulesForInstallation() {
    return null;
  }

  @Override
  public void onDestroy() {
    Toothpick.closeScope(this);
    super.onDestroy();
  }

  protected Scope getScope() {
    return scope;
  }
}