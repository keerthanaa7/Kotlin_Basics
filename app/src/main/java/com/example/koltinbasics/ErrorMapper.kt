package com.example.koltinbasics

sealed class AppError {
    object NetworkError: AppError()
    object TimeOutError: AppError()
}

object ErrorMapper{
    fun mapErrorToResId(appError: AppError): Int{
        when(appError){
            is AppError.NetworkError -> return R.string.err_no_internet
            is AppError.TimeOutError -> return R.string.err_timeout
            else -> return R.string.err_unknown
        }
    }
}