package home.oleg.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import home.oleg.dagger.presenter.Presenter;
import home.oleg.dagger.view.MainView;
import home.oleg.dagger.view_model.ItemViewModel;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject Presenter<MainView> presenter;

    @BindView(R.id.tv_items) TextView tvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerApplication.getComponent().mainActivityComponent().inject(this);
    }

    @Override
    public void showItems(List<ItemViewModel> itemViewModels) {
        for (ItemViewModel itemViewModel : itemViewModels) {
            tvItems.append(itemViewModel.getName() + "\n");
        }
    }

    @Inject
    public void onPresenterReady() {
        presenter.attachView(this);
        presenter.fetchItems();
    }

    @OnClick(value = R.id.button)
    void goToDetail(){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }

}
