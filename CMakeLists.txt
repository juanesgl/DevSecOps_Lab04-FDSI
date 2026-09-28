cmake_minimum_required(VERSION 3.10)
project(VulnerableApp)
set(CMAKE_CXX_STANDARD 17)
add_executable(VulnerableApp 
    src/main.cpp 
    src/auth.cpp 
    src/database.cpp 
    src/network.cpp 
    src/file_system.cpp
)