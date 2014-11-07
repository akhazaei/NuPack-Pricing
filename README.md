NuPack-Pricing
==============

Source code for NuPack Price Estimator API

Pricing Problem
===============

NuPack is responsible for taking existing products and repackaging them for sale at electronic

stores like FutureShop and Best Buy. Companies will phone up NuPack, explain the process

and NuPack needs to quickly give them an estimate of how much it will cost. Different markups

to the job:

●-Without Exception, there is a flat markup on all jobs of 5%

●●-For each person that needs to work on the job, there is a markup of 1.2%

●●-Markups are also added depending on the types of materials involved:

○●-If pharmaceuticals are involved, there is an immediate 7.5% markup

○●-For food, there is a 13% markup

○●-Electronics require a 2% markup

○●-everything else, there is no markup

Another system calculates the base price depending on how many products need to be

repackaged. As such, the markup calculator should accept the initial base price along with the

different categories of markups and calculate a final cost for a project.

The flat markup is calculated first and then all other markups are calculated on top of the base

price plus flat markup.
