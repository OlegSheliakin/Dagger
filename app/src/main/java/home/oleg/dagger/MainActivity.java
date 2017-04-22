package home.oleg.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuAdapter;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import home.oleg.dagger.presenter.MainPresenter;
import home.oleg.dagger.presenter.Presenter;
import home.oleg.dagger.view_model.ItemViewModel;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject MainPresenter presenter;

    @BindView(R.id.tv_items) TextView tvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerApplication.getComponent();
    }

    @Override
    public void showItems(List<ItemViewModel> itemViewModels) {
        itemViewModels.forEach(itemViewModel -> tvItems.append(itemViewModel.getName() + "\n"));
    }
}
