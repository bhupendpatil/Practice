#install.packages("tm")
#install.packages("textreuse")
#install.packages("devtools")
#install.packages("ggplot2")

library(tm)

my.corpus <- Corpus(DirSource("rcorpus")) #path for rcorpus folder
my.corpus <- tm_map(my.corpus, removeWords, stopwords("english"))
my.tdm <- TermDocumentMatrix(my.corpus)
inspect(my.tdm)
my.df <- as.data.frame(inspect(my.tdm))
barplot(as.matrix(my.tdm))

#color part
#color <- c("red","green","blue","orange","yellow","pink")
#barplot(as.matrix(my.tdm),col = color)