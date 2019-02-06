#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation


# In[ ]:


def load_dataset(name):
    return np.loadtxt(name)


# In[ ]:


def euclidean(a,b):
    return np.linalg.norm(a-b)


# In[ ]:


def kmeans(k, epsilon=0, distance='euclidean'):
    #list to store past centroid
    history_centroid=[]#not part of algorithm
    #set the distance calculatio type
    if distance == 'euclidean':
        dist_method = euclidean
    #set the data set
    dataset=load_dataset('durudataset.txt')
    #get the number of rows and coloumn for features
    num_instances, num_features = dataset.shape
    #define k centroids (how many cluster we want to define)
    prototypes = dataset[np.random.randint(0, num_instances-1, size=k)]
    #set this to our list of past centroid
    history_centroid.append(prototypes)
    #to keep track of centroid
    prototype_old = np.zeros(prototypes.shape)
    #to store cluster
    belongs_to= np.zeros((num_instances,1))
    norm = dist_method(prototypes, prototype_old)
    iteration=0
    while norm > epsilon:
        iteration+=1
        norm= dist_method(prototypes,prototype_old)
        #for each instance  in data set
        for index_instance, instance in enumerate(dataset):
            dist_vec = np.zeros((k,1))
            #for each centroid
            for index_prototype, prototype in enumerate(prototypes):
                #compute distance each datapoint
                dist_vec[index_prototype]= dist_method(prototype,instance)
            #find the smallest distance
            belongs_to[index_instance,0]= np.argmin(dist_vec)

        tmp_prototypes = np.zeros((k,num_features))

        #for each cluster
        for index in range(len(prototypes)):
            #get all the points assigned to a cluster
            instances_close = [i for i in range(len(belongs_to)) if  belongs_to[i]==index]
            #find the mean of those points, this is our new centroid
            prototype = np.mean(dataset[instances_close], axis=0)
            #add our centroid to our new temporary list
            tmp_prototypes[index,:]= prototype
        prototypes=tmp_prototypes
        history_centroid.append(tmp_prototypes)
    return prototypes, history_centroids, belongs_to



# In[ ]:


#lets define a plotting algorithm for our dataset and our centroids
def plot(dataset, history_centroids, belongs_to):
    #we'll have 2 colors for each centroid cluster
    colors = ['r', 'g']

    #split our graph by its axis and actual plot
    fig, ax = plt.subplots()

    #for each point in our dataset
    for index in range(dataset.shape[0]):
        #get all the points assigned to a cluster
        instances_close = [i for i in range(len(belongs_to)) if belongs_to[i] == index]
        #assign each datapoint in that cluster a color and plot it
        for instance_index in instances_close:
            ax.plot(dataset[instance_index][0], dataset[instance_index][1], (colors[index] + 'o'))

    #lets also log the history of centroids calculated via training
    history_points = []
    #for each centroid ever calculated
    for index, centroids in enumerate(history_centroids):
        #print them all out
        for inner, item in enumerate(centroids):
            if index == 0:
                history_points.append(ax.plot(item[0], item[1], 'bo')[0])
            else:
                history_points[inner].set_data(item[0], item[1])
                print("centroids {} {}".format(index, item))

                plt.show()


# In[ ]:


#main file
def execute():
    #load dataset
    dataset = load_dataset('durudataset.txt')
    #train the model on the data
    centroids, history_centroids, belongs_to = kmeans(2)
    #plot the results
    plot(dataset, history_centroids, belongs_to)


# In[ ]:
execute()


# In[ ]:
def plot_step_by_step(dataset, history_centroids, belongs_to):
    colors = ['r', 'g']

    fig, ax = plt.subplots()

    for index in range(dataset.shape[0]):
        instances_close = [i for i in range(len(belongs_to)) if belongs_to[i] == index]
        for instance_index in instances_close:
            ax.plot(dataset[instance_index][0], dataset[instance_index][1], (colors[index] + 'o'))

    history_points = []
    for index, centroids in enumerate(history_centroids):
        for inner, item in enumerate(centroids):
            if index == 0:
                history_points.append(ax.plot(item[0], item[1], 'bo')[0])
            else:
                history_points[inner].set_data(item[0], item[1])
                print("centroids {} {}".format(index, item))

                plt.pause(0.8)


# In[ ]:


for item in history_centroids:
    plot_step_by_step(dataset, [item], belongs_to)


# In[ ]:
