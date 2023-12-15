package com.example.foodiepal_culinarycompanion.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.databinding.FragmentBlogBinding
import com.example.foodiepal_culinarycompanion.fragments.adapter.BlogPostAdapter
import com.example.foodiepal_culinarycompanion.fragments.model.BlogPost

class BlogFragment: Fragment() {

    private lateinit var binding: FragmentBlogBinding
    private val posts = ArrayList<BlogPost>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_blog, container, false)
        binding = FragmentBlogBinding.bind(view)

        posts.add(BlogPost("Exploring Kotlin Coroutines", "Learn how to use coroutines in Kotlin", "John Doe", "12/06/2023", "In this post, we'll dive into the world of Kotlin coroutines and explore their usage in asynchronous programming.",R.drawable.spaghetti ))
        posts.add(BlogPost("Building Modern Android Apps", "Tips and best practices for building Android apps", "Jane Smith", "12/07/2023", "Discover the latest tools and techniques for developing modern Android applications with a focus on user experience and performance.", R.drawable.chicken))
        posts.add(BlogPost("Mastering React Hooks", "Deep dive into React functional components and hooks", "Alice Johnson", "12/08/2023", "Explore the power of React Hooks to manage state and side effects in functional components, making your React applications more modular and scalable.", R.drawable.vegetarian))
        posts.add(BlogPost("Introduction to Machine Learning", "Getting started with machine learning concepts", "Robert Brown", "12/09/2023", "This post provides a beginner-friendly introduction to machine learning, covering key concepts, algorithms, and practical applications.", R.drawable.bbq))
        posts.add(BlogPost("The Art of Code Review", "Best practices for effective code reviews", "Emily Wilson", "12/10/2023", "Learn how to conduct and participate in code reviews effectively, fostering collaboration and maintaining code quality within your development team.", R.drawable.caprese))
        posts.add(BlogPost("Understanding Blockchain Technology", "A comprehensive guide to blockchain", "Michael Anderson", "12/11/2023", "Delve into the fundamentals of blockchain technology, its decentralized nature, and its applications beyond cryptocurrencies.", R.drawable.chicken))
        posts.add(BlogPost("Cooking 101: Pasta Carbonara Recipe", "Step-by-step guide to make a classic Pasta Carbonara", "Chef Julia", "12/12/2023", "Follow this easy recipe to create a delicious Pasta Carbonara with crispy bacon, creamy sauce, and perfectly cooked pasta.", R.drawable.bbq))
        posts.add(BlogPost("Effective Time Management Strategies", "Boost your productivity with these time management tips", "David Miller", "12/13/2023", "Discover practical strategies for managing your time more effectively, optimizing your workflow, and achieving your goals.", R.drawable.caprese))
        posts.add(BlogPost("The Importance of UX in Web Design", "Enhance user experience through thoughtful web design", "Sophie Carter", "12/14/2023", "Explore the crucial role of user experience (UX) in web design and learn how to create websites that prioritize usability and user satisfaction.", R.drawable.vegetarian))
        posts.add(BlogPost("Healthy Lifestyle Habits", "Simple habits for a healthier and happier life", "Dr. Alex Johnson", "12/15/2023", "Incorporate these easy-to-follow habits into your daily routine to promote overall well-being and lead a healthier lifestyle.", R.drawable.spaghetti))

        val adapter = BlogPostAdapter(posts, ::sharePost)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

    private fun sharePost(position: Int){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = ("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, posts[position].title)
        intent.putExtra(Intent.EXTRA_EMAIL,posts[position].content)
        if(intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }
    }
}