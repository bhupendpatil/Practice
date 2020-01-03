#install.packages("tm")
#install.packages("textreuse")
#install.packages("devtools")
#install.packages("ggplot2")

library(tm)

my.corpus <- Corpus(DirSource("rcorpus")) #path for rcorpus folder
my.corpus <- tm_map(my.corpus, removeWords, stopwords("english"))
my.tdm <- TermDocumentMatrix(my.corpus)

my.dtm <- DocumentTermMatrix(my.corpus, control = list(weighting = weightTfIdf, stopwords = TRUE))

my.df <- as.data.frame(inspect(my.tdm))
my.df.scale <- scale(my.df)
d <- dist(my.df.scale,method="euclidean")
fit <- hclust(d, method="ward")
plot(fit)

#for bar
#barplot(as.matrix(my.tdm))