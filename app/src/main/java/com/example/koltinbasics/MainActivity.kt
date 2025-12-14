package com.example.koltinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.koltinbasics.ui.theme.KoltinBasicsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okio.IOException
import kotlin.math.max
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoltinBasicsTheme {
           /*     val userlist = listOf<User>(
                    User(11, "user1", 30),
                    User(2, "user2", 40),
                    User(1, "user3", 30)
                )
                val agecomparator = Comparator<User> { user, user1 ->
                    user.age.compareTo(user1.age)
                }
                val sortedlist = userlist.sortedWith(agecomparator)
                for (user in sortedlist) {
                    Log.d(TAG, "user ${user}")
                }*/
              /*  val studentscorelist = listOf<StudentScore>(
                    StudentScore("student1", 1),
                    StudentScore("student2", 2),
                    StudentScore("student3", 3),
                    StudentScore("student4", 4),
                    StudentScore("student5", 5),
                    StudentScore("student6", 6)
                )

                val (validlist, invalidlist) = sortedlist.partition { user -> user.id > 2 }
                validlist.forEach { user -> Log.d(TAG, " valid USER ${user}") }
                invalidlist.forEach { user -> Log.d(TAG, "invalid USER ${user}") }*/
            //    val mainViewModel: MainViewModel = MainViewModel()
                //  mainViewModel.refreshDashboard()
              //  mainViewModel.timeoutexample()
              //  mainViewModel.loaddata()


                    /*     Log.d(TAG, "fetching retry logic")
                    processdataforRetryWhen().retryWhen { cause, attempt ->
                        if(attempt < 3){
                            val delayTime = (2.0.pow(attempt.toDouble()) * 1000).toLong()
                            Log.d(TAG, "attempt ${attempt}  cause ${cause}")
                            delay(delayTime)
                            true
                        }else {
                            false
                        }
                    }.catch {
                        e -> emit("exception ${e}")
                    }.collect {
                        result -> Log.d(TAG, "result ${result}")
                    }
                }*/

                  /*      val sampleViewModel: SampleViewModel = viewModel()
                        val uistate by sampleViewModel.uistate.collectAsStateWithLifecycle()
                        when (val state = uistate) {
                            is UIState.Loading -> Log.d(TAG, "loading")
                            is UIState.Success -> Log.d(TAG, "SUCCESS")
                        }*/
                 /* runBlocking {
                      val coldjob1 = launch {
                          getNumbersFlow().collect{result -> Log.d(TAG, "result ${result}")}
                      }
                      delay(250)
                      val coldjob2 = launch {
                          getNumbersFlow().collect{result -> Log.d(TAG, "result ${result}")}
                      }
                  }*/

         /*       val newsHotflowViewmodel: NewsHotflowViewmodel = viewModel()
                val newsstate by newsHotflowViewmodel.newsoutput.collectAsStateWithLifecycle()*/

               /* LaunchedEffect(Unit){
                    val job1 = launch {
                        newsHotflowViewmodel.newsoutput.collect { result -> Log.d(TAG, "hot flow job 1result ${result}") }
                    }
                    delay(500)
                 //   newsHotflowViewmodel.fetchnews()
                    val job2 = launch {
                        newsHotflowViewmodel.newsoutput.collect { result -> Log.d(TAG, "hot flow job 2 result ${result}") }
                    }
                }*/

                val SharedFlowExample: SharedFlowExample = viewModel()
               // val sharedflowstate by SharedFlowExample.sharedflowdata.collectAsStateWithLifecycle("waiting")
/*
                LaunchedEffect(Unit) {
                    val job1 = launch {
                       SharedFlowExample.sharedflowdata.collect { result -> Log.d(TAG, "shared flow job 1 ${result}")  }
                    }

                    val job2 = launch {
                        SharedFlowExample.sharedflowdata.collect { result -> Log.d(TAG, "shared flow job 2 ${result}")  }
                    }
                }*/

                val recordRepository = RecordRepository()
            /*    val recordViewModel: RecordViewModel = viewModel(factory = object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                       if(modelClass.isAssignableFrom(RecordViewModel::class.java)){
                           return RecordViewModel(recordRepository) as T
                       }else{
                           throw IllegalArgumentException("cannot create view model")
                       }
                    }
                })
                LaunchedEffect(Unit) {
                    val job = recordViewModel.recordflow.collect { result ->  Log.d(TAG, "collected record result ${result}")}
                }*/

              /*  val merchantRepository = remember { MerchantRepository() }
                LaunchedEffect(Unit) {
                    merchantRepository.getMerchantData().collect { merchantdata ->
                        when(merchantdata){
                            is ApiInterface.Loading -> Log.d(TAG, "merchant data loading")
                            is ApiInterface.Success -> Log.d(TAG, "merchant data Success")
                            is ApiInterface.Error -> Log.d(TAG, "failure")
                        }
                    }
                }*/

           /*     val merchantDTO = MerchantDTO("1", "business_name", 1)
                Log.d(TAG, "merchant dto ${merchantDTO}")
                val merchantentity = merchantDTO.toEntity()
                val merchant = merchantentity.toDomain()
                val merchantuistate = merchant.toUIState()
                 val dataRepository = DataRepository()*/
              /*  LaunchedEffect(Unit) {
                    launch {
                        dataRepository.data.collect { dataRepositorydata -> Log.d(TAG, "datarepository data ${dataRepositorydata}") }
                    }
                }
*/
                val refreshcacheEg = RefreshcacheEg()
              /*  LaunchedEffect(Unit) {
                    refreshcacheEg.getData().collect { value  -> Log.d(TAG, "refresh data ${value}") }
                }*/

            /*    LaunchedEffect(Unit) {
                    launch {
                        val cacheExpiryEg: CacheExpiryEg<String> = CacheExpiryEg(2000)
                        cacheExpiryEg.put("Apple")
                        Log.d(TAG, "get cache data  at 0s ${cacheExpiryEg.getData()}")
                        delay(1000)
                        Log.d(TAG, "get cache data  at 1s ${cacheExpiryEg.getData()}")
                        delay(1500)
                        Log.d(TAG, "get cache data  at 2.5s ${cacheExpiryEg.getData()}")
                    }
                }*/
                val simplePagingSource = SimplePagingSource()
                val currentkey:Int? = 2
         /*       LaunchedEffect(Unit) {
                   simplePagingSource.loadpage(2)
                    repeat(3){

                    }
                }*/

               /* LaunchedEffect(Unit) {
                   var result = try{
                       RetryUtil(){
                           fetchdata()
                       }
                   }catch (e: Exception){
                   }
                }*/

            /*    LaunchedEffect(Unit) {
                    val result = safecall { fetchprofile() }
                    when(result){
                        is ResourceUIState.Success -> Log.d(TAG, " ResourceUIState success")
                        is ResourceUIState.Error -> Log.d(TAG, "ResourceUIState error")
                        ResourceUIState.Loading -> Log.d(TAG, "ResourceUIState loading")
                    }
                }*/
             /*   val breaker = CircuitBreaker(3)
                val unreliablecall = {
                    Log.d(TAG, "throw exception unreliable call ")
                    throw IOException("IO exception unreliable call ")
                }*/
            /*    LaunchedEffect(Unit) {
                    repeat(5){
                        attempt ->
                        Log.d(TAG, "attempt ${attempt}")
                        try {
                            breaker.process { unreliablecall()  }
                        }catch (e: Exception){
                            Log.d(TAG, "exception ${e}")
                        }
                    }
                }*/
           /*     LaunchedEffect(Unit) {
                    val apiService = ApiService()
                    val cacheService = CacheService()
                    val dataRepository1 = DataRepository1(apiService, cacheService)
                    val result = try{
                        dataRepository1.getData()
                    }catch (e: Exception){
                        Log.d(TAG, "exception ${e}")
                    }
                    Log.d(TAG, "data repository 1 ${result}")

                }
*/
/*
                val result = getResult(2)
                val message = result.fold(onSuccess = {Log.d(TAG, "result example success")},
                    onFailure = {Log.d(TAG, "result example failure")})
                Log.d(TAG , "message ${message}")

                val appError = AppError.NetworkError
                val resultid = ErrorMapper.mapErrorToResId(appError)
                Log.d(TAG, "resultid ${getString(resultid)}")*/

          /*      val maxattempt = 3;
                for(i in 0..maxattempt){
                    try {
                        val result = apicall()
                        Log.d(TAG, "result from api call ${result}")
                        break
                    }catch (e: Exception){
                        if(i == maxattempt){
                            Log.d(TAG, "all attempts done no success")
                        }else{
                            Log.d(TAG, "sleeping for jitter time but since its too long just sleeping for a short time")
                            Thread.sleep(10)
                        }
                    }
                }*/

                val prefmanager = SimplePrefManager(this)
                LaunchedEffect(Unit) {
                launch {
                        prefmanager.scoreflow.collect { value ->  Log.d(TAG, "collected value ${value}") }

                    }
                    launch {
                        prefmanager.savescore(100)
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        KoltinBasicsTheme {
            Greeting("Android")
        }
    }
}