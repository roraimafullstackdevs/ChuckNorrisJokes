import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.Model.Joke
import com.example.chucknorrisjokes.Network.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    private val jokeRepository = JokeRepository()

    val jokeLiveData: MutableLiveData<Joke> = MutableLiveData()

    fun fetchRandomJoke() {
        GlobalScope.launch(Dispatchers.Main) {
            val joke = jokeRepository.getRandomJoke()
            joke?.let {
                jokeLiveData.postValue(it)
            }
        }
    }
}
