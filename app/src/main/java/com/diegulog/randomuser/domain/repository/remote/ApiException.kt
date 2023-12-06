package com.diegulog.randomuser.domain.repository.remote

import java.io.IOException

class ApiException(message: String): IOException(message)