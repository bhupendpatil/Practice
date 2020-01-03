#install.packages("tm")
#install.packages("devtools")

library(tm)

readinteger <- function() {
  n <- readline(prompt = "Enter value of k-1: ")
  k <- as.integer(n)
  
  filename = "file1.txt" #give file path else make file in Documents folder
  conn <- file(filename,open="r")
  
  u1 <- readLines(conn)
  
  Shingle <- 0
  i <- 0
  
  while(i<nchar(u1)-k+1){
    Shingle[i] <- substr(u1, start=i, stop=i+k)
    print(Shingle[i])
    i = i + 1
  }
}

readinteger()