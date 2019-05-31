const val GITHUB_API_BASE_URL = "https://api.github.com/"

interface GithubService{

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String): Deferred<Response<List<GitHubRepo>>>

    companion object {
        fun getGitHubService():GithubService{
            return Retrofit.Builder()
                .baseUrl(GITHUB_API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(GithubService::class.java)
        }
    }


}