interface GithubService{

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String): Deferred<Response<List<GitHubRepo>>>

    companion object {
        fun getGitHubService():GithubService{
            return Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(GithubService::class.java)
        }
    }


}