package com.diegulog.randomuser.domain.repository.remote

import java.io.IOException

class NetworkException: IOException("Unable to connect to the server")
