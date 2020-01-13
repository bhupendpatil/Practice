#install.packages("tm")
#install.packages("textreuse")
#install.packages("devtools")
#install.packages("ggplot2")

library(tm)
library(textreuse)

minhash <- minhash_generator(20, seed = 235)
ats <- TextReuseCorpus(dir = "rcorpus", tokenizer = tokenize_ngrams, n = 4, minhash_func = minhash)
buckets <- lsh(ats, bands = 20, progress = interactive())
buckets
candidates <- lsh_candidates(buckets)
candidates
scores <- lsh_compare(candidates, ats, jaccard_similarity, progress = FALSE)
scores
color <- c("red","green","blue","orange","yellow","pink")
barplot(as.matrix(scores),col = color)